<template>
  <v-row class="mt-10 ma-2" no-gutters>
    <v-col class="text-center">
      <p>Id</p>
    </v-col>
    <v-col class="text-center">
      <p>Title</p>
    </v-col>
    <v-col class="text-center">
      <p>Status</p>
    </v-col>
    <v-col class="text-center">
      <p>Deadline</p>
    </v-col>
    <v-col class="text-center">
      <p>Assignee</p>
    </v-col>
  </v-row>
  <div class="tickets pt-10">
    <v-expansion-panels v-model="panel" multiple variant="popout">
      <TaskListItem v-for="task in store.tasks" :key="task.id" :task="task" />
    </v-expansion-panels>
  </div>
</template>

<script setup>
import TaskListItem from "@/components/Task/TaskListItem.vue";
import { useTaskStore } from "@/stores/taskStore.js";

const store = useTaskStore();

const tasks = [
  {
    id: 23,
    title: "Candidates tab not working",
    description:
      "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    projectId: 1,
    status: "Open",
    assigneeId: 1,
    createdBy: "2",
    createdOn: "2022-05-23",
    deadline: "2022-06-01",
  },
  {
    id: 24,
    title: "Candidates tab not working",
    description:
      "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    projectId: 1,
    status: "Open",
    assigneeId: 1,
    createdBy: "2",
    deadline: "2022-06-01",
  },
  {
    id: 25,
    title: "Candidates tab not working",
    description:
      "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    projectId: 1,
    status: "Open",
    assigneeId: 1,
    createdBy: "2",
    deadline: "2022-06-01",
  },
  {
    id: 26,
    title: "Candidates tab not working",
    description:
      "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    projectId: 1,
    status: "Open",
    assigneeId: 1,
    createdBy: "2",
    deadline: "2022-06-01",
  },
];
</script>