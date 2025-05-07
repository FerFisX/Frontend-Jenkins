const express = require('express');
const path = require('path');
const app = express();
const port = 3000; // Puedes cambiar el puerto si lo deseas

// Servir archivos estáticos desde la carpeta raíz
app.use(express.static(path.join(__dirname, '.')));

// Ruta principal para servir el archivo index.html
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html'));
});

app.listen(port, () => {
  console.log(`Servidor corriendo en http://localhost:${port}`);
});
