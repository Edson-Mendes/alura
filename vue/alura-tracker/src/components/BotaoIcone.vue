<template>
  <button class="button" @click="acao">
    <span class="icon">
      <i :class="icon"></i>
    </span>
  </button>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "BotaoIcone",
  emits: ["acao"],
  props: {
    icon: {
      type: String,
      default: "",
    },
  },
  methods: {
    acao() {
      this.$emit("acao");
    },
  },
});
</script>
