<template>
  <main
    class="columns is-gapless is-multiline"
    :class="{ 'modo-escuro': modoEscuroAtivo }"
  >
    <div class="column is-one-quarter">
      <BarraLateral @ao-tema-alterado="trocarTema" />
    </div>
    <div class="column is-three-quarter conteudo">
      <Formulario @ao-salvar-tarefa="salvarTarefa" />
      <div class="lista">
        <Tarefa
          v-for="(tarefa, index) in tarefas"
          :key="index"
          :tarefa="tarefa"
          @ao-deletar="deletarTarefa(index)"
        />
        <Box v-if="listaEstaVazia"> Você não está muito produtivo hoje :( </Box>
      </div>
    </div>
  </main>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import BarraLateral from "./components/BarraLateral.vue";
import Formulario from "./components/Formulario.vue";
import Tarefa from "./components/Tarefa.vue";
import ITarefa from "./interfaces/ITarefa";
import Box from "./components/Box.vue";

export default defineComponent({
  name: "App",
  data() {
    return {
      tarefas: [] as ITarefa[],
      modoEscuroAtivo: false,
    };
  },
  computed: {
    listaEstaVazia(): boolean {
      return this.tarefas.length === 0;
    },
  },
  methods: {
    salvarTarefa(tarefa: ITarefa) {
      this.tarefas.push(tarefa);
    },
    trocarTema(modoEscuroAtivo: boolean) {
      this.modoEscuroAtivo = modoEscuroAtivo;
    },
    deletarTarefa(indice: number) {
      console.log("Deletando elemento ", indice);
    },
  },
  components: {
    BarraLateral,
    Formulario,
    Tarefa,
    Box,
  },
});
</script>

<style>
main {
  --bg-primario: #ffffff;
  --texto-primario: #000000;
}

main.modo-escuro {
  --bg-primario: #2b2d42;
  --texto-primario: #dddddd;
}

.lista {
  padding: 1.25rem;
}

.conteudo {
  background-color: var(--bg-primario);
}
</style>
