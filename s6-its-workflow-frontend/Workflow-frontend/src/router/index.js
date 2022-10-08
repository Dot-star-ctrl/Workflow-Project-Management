import { createRouter, createWebHistory } from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import { authGuard } from '@auth0/auth0-vue';
import Dashboard from "@/views/DashboardView.vue";
import Workspaces from "@/views/workspaces/WorkspacesView.vue";
import WorkspaceView from "@/views/workspaces/WorkspaceView.vue";
import CreateWorkspaceView from "@/views/workspaces/CreateWorkspaceView.vue";
import CreateProjectView from "@/views/projects/CreateProjectView.vue";
import ProjectView from "@/views/projects/ProjectView.vue";
import Users from "@/views/users/UsersView.vue";
import TermsAndConditions from "@/views/TermsAndConditions.vue";

const routes = [
  {
    path: "/",
    redirect: "/dashboard",
    name: "Dashboard",
    component: DefaultLayout,
    beforeEnter: authGuard,
    children: [
      { path: "dashboard", name: "Dashboard", component: Dashboard },
    ],
  },
  {
    path: "/workspaces",
    name: "Workspaces",
    component: DefaultLayout,
    beforeEnter: authGuard,
    children: [
      { path: "/workspaces", name: "Workspaces", component: Workspaces },
      { path: "/workspaces/create", name: "CreateWorkspace", component: CreateWorkspaceView },
      { path: "/workspaces/:id/projects", name: "WorkspaceView", component: WorkspaceView },
      { path: "/workspaces/:id/projects/create", name: "CreateProject", component: CreateProjectView },
      { path: "/workspaces/:id/projects/:projectid", name: "ProjectView", component: ProjectView },
    ],
  },
  {
    path: "/users",
    name: "Users",
    component: DefaultLayout,
    beforeEnter: authGuard,
    children: [
      { path: "users", name: "Users", component: Users },
    ],
  },
    {
        path: "/workflow-terms",
        name: "Workflow Terms and Conditions",
        component: TermsAndConditions
    },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
