# Rabbit MQ

```
files.images.png
files.images.jpg
files.documents.pdf
files.documents.html

ImagesPngDownloader -> files.images.png
ImagesJpegDownloader -> files.images.jpg

DocumentsDownloader -> files.documents.* -> files.documents.pdf/files.documents.html

FilesAnalytics -> files.# -> files.images.png
                             files.images.jpg
                             files.documents.pdf
                             files.documents.html
```
