document.addEventListener('DOMContentLoaded', function() {
    const botonesVerMas = document.querySelectorAll('.ver-mas');
    const modal = document.getElementById('modal-tour');
    const modalTitulo = document.getElementById('modal-titulo');
    const modalDescripcion = document.getElementById('modal-descripcion');
    const botonCerrarModal = document.querySelector('.cerrar-modal');

    botonesVerMas.forEach(boton => {
        boton.addEventListener('click', function() {
            const tourCard = this.parentNode;
            const destino = tourCard.dataset.destino;
            const descripcion = tourCard.dataset.descripcion;

            modalTitulo.textContent = destino;
            modalDescripcion.textContent = descripcion;
            modal.style.display = "block";
        });
    });

    botonCerrarModal.addEventListener('click', function() {
        modal.style.display = "none";
    });

    window.addEventListener('click', function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
});
