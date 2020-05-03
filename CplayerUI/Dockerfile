#Frontend DockerFile

# base image
FROM node:13.3.0

RUN mkdir -p usr/src/app
WORKDIR /usr/src/app
COPY dist/CplayerUI /usr/src/app/dist
COPY package-container.json /usr/src/app
RUN mv package-container.json package.json
RUN npm install
RUN npm install -g @angular/cli@9.1.1
CMD ng serve
