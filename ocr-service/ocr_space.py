import requests


def ocr_space_url(url, overlay=False, api_key='helloworld', language='eng', iscreatesearchablepdf=True,
                  issearchablepdfhidetextlayer=True):
    payload = {'url': url,
               'isOverlayRequired': overlay,
               'apikey': api_key,
               'language': language,
               'iscreatesearchablepdf': iscreatesearchablepdf,
               'issearchablepdfhidetextlayer': issearchablepdfhidetextlayer
               }
    r = requests.post('https://api.ocr.space/parse/image',
                      data=payload,
                      )

    return r.content.decode()
