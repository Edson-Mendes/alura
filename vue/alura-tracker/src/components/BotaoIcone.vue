<template>
  <span class="icon" @click="acao" :style="estilo">
    <i :class="icon"></i>
  </span>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "BotaoIcone",
  emits: ["acao"],
  props: {
    icon: {
      type: String,
      required: true,
    },
    estilo: {
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
