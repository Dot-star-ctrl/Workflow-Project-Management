FROM node:lts-alpine as build-stage

WORKDIR /app

COPY ./Workflow-frontend /app

RUN npm install

RUN npm run build

# production stage
FROM nginx:1.21-alpine as production-stage

COPY --from=build-stage /app/dist /usr/share/nginx/html

ENTRYPOINT ["nginx", "-g", "daemon off;"]
