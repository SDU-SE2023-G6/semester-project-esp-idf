
<script setup>
  import {onMounted} from "vue";
  import ace from "ace-builds";
  import 'ace-builds/webpack-resolver'
  import 'ace-builds/src-noconflict/theme-clouds';
  import 'ace-builds/src-noconflict/theme-monokai';
  import 'ace-builds/src-noconflict/mode-latex';
  import 'ace-builds/src-noconflict/mode-javascript';
  import 'ace-builds/src-noconflict/ext-language_tools'; // for autocompletion
  import 'ace-builds/esm-resolver';
  import '../stores/xtextRegex.js' //important to import the syntax definition
  
  

  onMounted(() => {

    const editor = ace.edit('editor', {
      mode: 'ace/mode/my_custom_mode',
    });

    editor.setTheme("ace/theme/monokai"); // Set theme, for example, to 'monokai'
    editor.setFontSize(14); // Change font size
    editor.setShowPrintMargin(false); // Hide the print margin
    editor.setOptions({
        enableBasicAutocompletion: true,
        enableSnippets: true,
        enableLiveAutocompletion: false
    });

    editor.syntaxHighlighting = true;
  });

  const saveDsl = () => {
    const editor = ace.edit('editor');
    const dslText = editor.getValue();
    console.log(JSON.stringify(dslText));    

    fetch('http://localhost:8081/save-dsl', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({dslText}),
    })
  }


  </script>

  <template>
    <div class="flex column">
        <div class="ace-container">
      <div id="editor"></div>
    </div>
    <button @click="saveDsl()">Save DSL</button>
    </div>
   
  </template>
  
  <style scoped>
  .flex {
    display: flex;
    justify-content: center;
    gap: 2em;
  }
  .column {
    flex-direction: column;
  }

  button {
    padding: 1em 2em;
    background-color: #4CAF50; 
    border: none;
    cursor: pointer;
    color: white;
    font-weight: bold;
  }
  button:hover {
    background-color: #45a049;
  }

  #editor {
    width: 100%;
    height: 400px;
  }
  </style>