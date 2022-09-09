<template>
  <button class="button" @click="acao" :disabled="isDisabled">
    <span class="icon">
      <i :class="faIcon"></i>
    </span>
    <span>{{ text }}</span>
  </button>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Botao",
  emits: ["acao"],
  props: {
    isDisabled: {
      type: Boolean,
      default: false,
    },
    faIcon: {
      type: String,
      default: "",
    },
    text: {
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
