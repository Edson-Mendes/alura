<template>
  <div class="box has-text-weight-bold" :style="estilo">
    <slot></slot>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Box",
  data() {
    return {
      estilo: {
        "background-color": "#faf0ca",
      },
    };
  },
});
</script>

<!-- <style scoped>
.box {
  background-color: #faf0ca;
}
</style> -->
