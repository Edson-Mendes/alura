<template>
  <Box>
    <div class="columns">
      <div class="column is-8">
        {{ tarefa.descricao || "Tarefa sem descrição" }}
      </div>
      <div class="column is-3">
        <Cronometro :tempo-em-segundos="tarefa.duracaoEmSegundos" />
      </div>
      <div class="column is-1">
        <BotaoIcone
          @acao="deletar"
          :icon="'fas fa-trash'"
          :estilo="'color: black;'"
        />
      </div>
    </div>
  </Box>
</template>

<script lang="ts">
import { defineComponent, PropType } from "vue";
import Cronometro from "./Cronometro.vue";
import Box from "./Box.vue";
import ITarefa from "@/interfaces/ITarefa";
import BotaoIcone from "./BotaoIcone.vue";

export default defineComponent({
  name: "Tarefa",
  props: {
    tarefa: {
      type: Object as PropType<ITarefa>,
      required: true,
    },
  },
  emits: ["aoDeletar"],
  methods: {
    deletar() {
      console.log("Deletando tarefa!!!");
      this.$emit("aoDeletar");
      console.log("tarefa deletada :)");
    },
  },
  components: { Cronometro, Box, BotaoIcone },
});
</script>
