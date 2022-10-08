import { defineStore } from "pinia";
import axiosClient from "@/axios";

export const useTaskStore = defineStore("task", {
  state: () => ({
    tasks: [],
    dialog: false,
    currentTask: {
      taskId: 0,
      title: "",
      description: "",
      projectId: 1,
      status: "",
      assigneeId: 1,
      createdBy: "",
      deadline: "",
    },
  }),
  actions: {
    getTasksByProjectId(projectId) {
      axiosClient
        .get(`/task/by-project/${projectId}`)
        .then((res) => {
          this.tasks = res.data;
        })
        .catch((error) => {
          return error;
        });
    },
    saveTask() {
      if (this.currentTask.taskId > 0) {
        axiosClient
          .put(`/task/${this.currentTask.taskId}`, this.currentTask)
          .then((res) => {
            return res;
          });
      } else {
        let newTaskId =
          (this.tasks.length ? this.tasks.slice(-1)[0].taskId : 0) + 1;
        this.currentTask.taskId = newTaskId;
        axiosClient.post("/task", this.currentTask).then((res) => {
          this.getTasksByProjectId(1);
          return res;
        });
      }
    },
    updateTask() {
      if (this.currentTask.taskId) {
        response = axiosClient
          .put(`/task/${this.currentTask.taskId}`, this.currentTask)
          .then((res) => {
            return res;
          });
      }
    },
    setCurrentTask(task) {
      this.currentTask = task;
    },
    deleteTask(taskId) {
      axiosClient.delete(`/task/${taskId}`).then((res) => {
        this.getTasksByProjectId(1);
        return res;
      });
    },
  },
  getters: {
    getTasks(state) {
      return state.tasks;
    },
    getTaskById: (state) => (taskId) => {
      return (taskId) => {
        return state.tasks.find((task) => task.taskId === taskId);
      };
    },
    getTasksByStatus: (state) => (status) => {
      return (status) => {
        return state.tasks.filter((task) => task.status === status);
      };
    },
    getTasksByAssigneeId: (state) => (assigneeId) => {
      return (assigneeId) => {
        return state.tasks.filter((task) => task.assigneeId === assigneeId);
      };
    },
  },
});
