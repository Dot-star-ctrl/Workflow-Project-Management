<template>
      <div class="pt-10 d-flex">
        <ProjectListItem 
        v-for="project in projects"
        :key="project.id"
        :project="project"
        />
      </div>
</template>

<script setup>
import ProjectListItem from "@/components/Project/ProjectListItem.vue";

const projects = [
  {
    id: 23,
    title: "Electrify",
    type: "Software related",
    description: "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    priority: "Medium",
    staus: "Open",
    createdAt: "5 days ago",
    updatedAt: "2 mins ago",
  },
    {
    id: 24,
    title: "Workflow",
    type: "Software related",
    description: "I am unable to submit my registration in the register as candidate tab",
    priority: "Medium",
    staus: "Open",
    createdAt: "2 days ago",
    updatedAt: "2 days ago",
  },
    {
    id: 25,
    title: "Microsoft",
    type: "",
    description: "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    priority: "Medium",
    staus: "Open",
    createdAt: "5 hours ago",
    updatedAt: "30 mins ago",
  },
    {
    id: 26,
    title: "Tesla",
    type: "Software related",
    description: "The candidates tab cant be reached,it sends me back to the index page everytime I click on it.",
    priority: "Medium",
    staus: "Open",
    createdAt: "5 days ago",
    updatedAt: "2 mins ago",
  },
];
</script>