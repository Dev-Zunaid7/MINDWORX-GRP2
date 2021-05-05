<template>
  <div class="home">
    <h1>{{ title }}</h1>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      title:''
    };
  },
  mounted(){
    fetch('http://localhost:8085')
    .then(response =>{
      return response.text();
    })
    .then(data =>{
      this.title = data;
    });
  }
}
</script>


