FROM node:latest

RUN mkdir -p /usr/applications/nodejs-app/
WORKDIR /usr/applications/nodejs-app/

COPY . /usr/applications/nodejs-app/

EXPOSE 8080

VOLUME /usr/applications/nodejs-app/storage

RUN npm install express
RUN npm install fs
RUN npm install body-parser

CMD node server.js


