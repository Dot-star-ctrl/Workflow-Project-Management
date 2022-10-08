
up:
	@docker compose up --build --no-deps -d

down:
	@docker compose down

restart:
	@make down && make up

build-backend:
	@cd s6-its-workflow
    @gradle build

rebuild-backend:
	@cd s6-its-workflow
	@gradle clean && gradle build

build-frontend:
	@s6-its-workflow-frontend
	@npm install
