# from urllib.request import urlopen
import hashlib
import country
from datetime import datetime

# For speed, temp map of hs_codes to import duty and vat
CET_TARRIFF = {
    '3918100000': {
        'import_duty': '20',
        'vat': '5'
    },
    '3918900000': {
        'import_duty': '20',
        'vat': '5'
    },
    '3919100000': {
        'import_duty': '10',
        'vat': '5'
    },
    '3919900000': {
        'import_duty': '5',
        'vat': '5'
    },
    '3920101000': {
        'import_duty': '10',
        'vat': '5'
    },
    '3920102000': {
        'import_duty': '20',
        'vat': '5'
    },
    '3920201000': {
        'import_duty': '10',
        'vat': '5'
    },
    '3920202000': {
        'import_duty': '20',
        'vat': '5'
    },
    '3920301000': {
        'import_duty': '10',
        'vat': '5'
    },
    '3920302000': {
        'import_duty': '20',
        'vat': '5'
    },
    '3920430000': {
        'import_duty': '10',
        'vat': '5'
    },
    '3920490000': {
        'import_duty': '10',
        'vat': '5'
    },
    '3920510000': {
        'import_duty': '10',
        'vat': '5'
    },
    '3920590000': {
        'import_duty': '10',
        'vat': '5'
    },
    '3920610000': {
        'import_duty': '5',
        'vat': '5'
    },
    '3920620000': {
        'import_duty': '5',
        'vat': '5'
    }
}


def scrape_pfi(data):
    doc_lines = data['ParsedResults'][0]['TextOverlay']['Lines']

    invoice_number = doc_lines[9]['Words'][0]['WordText']
    total_price = doc_lines[34]['Words'][0]['WordText']
    quantity = doc_lines[23]['Words'][0]['WordText']

    item = ''
    for word in doc_lines[24]['Words']:
        item = '{0} {1}'.format(item, word['WordText'])

    return dict(invoice_number=invoice_number, total_price=total_price, item=item, quantity=quantity)


def scrape_form_m(data):
    doc_lines = data['ParsedResults'][0]['TextOverlay']['Lines']

    hs_code = doc_lines[62]['Words'][0]['WordText']
    application_number = doc_lines[11]['Words'][0]['WordText']
    numbering = doc_lines[7]['Words'][0]['WordText']

    return dict(hs_code=hs_code, application_number=application_number, numbering=numbering,
                import_duty=CET_TARRIFF[hs_code]['import_duty'], vat=CET_TARRIFF[hs_code]['vat'])


def scrape_shipment_invoice(data):
    doc_lines = data['ParsedResults'][0]['TextOverlay']['Lines']

    invoice_number = doc_lines[5]['Words'][3]['WordText']
    invoice_amount = doc_lines[67]['Words'][0]['WordText']

    country_of_origin = doc_lines[73]['Words'][-1]['WordText']
    continent_of_origin = country.get_country_continent(country_of_origin)

    expected_date_of_shipment_temp = doc_lines[4]['Words'][0]['WordText']
    expected_date_of_shipment = datetime.strptime(expected_date_of_shipment_temp, '%d.%m.%Y').date()

    expected_date_of_arrival = country.get_expected_arrival_date(expected_date_of_shipment, continent_of_origin)

    return dict(invoice_number=invoice_number, invoice_amount=invoice_amount,
                country_of_origin=country_of_origin, continent_of_origin=continent_of_origin,
                expected_date_of_shipment=expected_date_of_shipment, expected_date_of_arrival=expected_date_of_arrival)


def scrape_bol(data):
    doc_lines = data['ParsedResults'][0]['TextOverlay']['Lines']

    bol_number = doc_lines[1]['Words'][4]['WordText']

    return dict(bol_number=bol_number.replace('$', 'S'))


def hash_file(file):
    hasher = hashlib.md5()
    hasher.update(file.read())

    return hasher.hexdigest()
