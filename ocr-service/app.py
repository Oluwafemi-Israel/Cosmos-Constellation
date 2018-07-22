from flask import Flask, request, render_template, jsonify
from werkzeug import secure_filename
from flask_cors import CORS

import os
import json
import azure_blobs
import ocr_space
import doc_scraper

app = Flask(__name__)
CORS(app)

OCR_API_KEY = os.environ['OCR_API_KEY']
DOC_TYPES = ['pfi', 'form_m', 'shipment_invoice', 'bol']
CONTAINER_NAME = 'some-test'
SCRAPER_MAPPING = {
    'pfi': doc_scraper.scrape_pfi,
    'form_m': doc_scraper.scrape_form_m,
    'shipment_invoice': doc_scraper.scrape_shipment_invoice,
    'bol': doc_scraper.scrape_bol
}


@app.route('/')
def home():
    return render_template('index.html')


@app.route('/submit_doc', methods=['POST'])
def submit_doc():
    if request.method == 'POST':

        for doc_type in DOC_TYPES:

            if request.files.get(doc_type):
                doc = request.files[doc_type]
                doc_name = secure_filename(doc.filename)

                blob_url = azure_blobs.create_blob(container_name=CONTAINER_NAME, file=doc, filename=doc_name)
                file_hash = doc_scraper.hash_file(doc)

                ocr_response = ocr_space.ocr_space_url(url=blob_url, api_key=OCR_API_KEY)
                filtered_data = SCRAPER_MAPPING[doc_type](json.loads(ocr_response))

                return jsonify(dict(doc_url=blob_url, doc_hash=file_hash, filtered=filtered_data, raw=ocr_response))

        return jsonify({'msg': 'the form field must have one of these names - {0}'.format(DOC_TYPES)})


if __name__ == '__main__':
    app.run(debug=True)
