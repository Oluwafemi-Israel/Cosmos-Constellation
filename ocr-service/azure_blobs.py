import uuid
import os

from azure.storage.blob import BlockBlobService

ACCOUNT_NAME = os.environ['ACCOUNT_NAME']
ACCOUNT_KEY = os.environ['ACCOUNT_KEY']

block_blob_service = BlockBlobService(account_name=ACCOUNT_NAME, account_key=ACCOUNT_KEY)


def create_blob(container_name, file, filename):
    blob_name = filename[:-4] + str(uuid.uuid4()) + filename[-4:]
    print(blob_name)

    block_blob_service.create_blob_from_bytes(container_name, blob_name, file.read())
    blob_url = block_blob_service.make_blob_url(container_name, blob_name)

    return blob_url
