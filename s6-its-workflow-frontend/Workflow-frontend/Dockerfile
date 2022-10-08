FROM node:14-alpine as pwa_base

ARG NODE_ENV

ENV NODE_ENV $NODE_ENV

WORKDIR /app/Workflow-frontend

COPY docker/docker-entrypoint.sh /usr/local/bin/docker-entrypoint

RUN chmod +x /usr/local/bin/docker-entrypoint

# Only copy relevant files for building a deployable app
COPY ./ /app/Workflow-frontend/

ENTRYPOINT ["docker-entrypoint"]

# HMR (Hot module reloading port)
EXPOSE 49153

# Build stage for staging
FROM pwa_base as pwa_build_staging
RUN if [ "$NODE_ENV" = 'staging' ]; then npm install && npm run build; else mkdir web; fi

# Build stage for production
FROM pwa_base as pwa_build_prod
RUN if [ "$NODE_ENV" = 'production' ]; then npm install && npm run build; else mkdir web; fi

# NGINX / http setup for both acceptance and production
FROM nginx:1.21-alpine as nginx_base

COPY ./docker/nginx.conf /etc/nginx/conf.d/default.conf
RUN apk add --no-cache curl

WORKDIR /src/public
EXPOSE 80
EXPOSE 3000
CMD ["nginx", "-g", "daemon off;"]

# NGINX for staging
FROM nginx_base as pwa_staging
COPY --from=pwa_build_staging /app/Workflow-frontend/dist /src/public
CMD ["nginx", "-g", "daemon off;"]

# NGINX for production
FROM nginx_base as pwa_prod
COPY --from=pwa_build_prod /app/Workflow-frontend/dist /src/public

FROM pwa_base as pwa_dev

RUN apk add --no-cache curl

WORKDIR /app/Workflow-frontend

EXPOSE 3000

CMD ["npm", "run", "dev"]
