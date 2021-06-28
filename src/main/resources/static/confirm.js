// const deleteButton = document.querySelector("#deleteButton");
// console.log(deleteButton);

// deleteButton.addEventListener('click', function(target){
//     console.warn('CLICKED')
// });

function eliminar({id, name, telefono}) {
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this data!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then(async (willDelete) => {
        if (willDelete) {
            await fetch(`/eliminar/${id}`)
                .then(deleted => {
                    console.log(deleted);
                    if(deleted.ok && deleted.redirected){
                      swal(`Poof! la persona ${name} fue removida.`, {
                        icon: "success",
                      });
                      window.location.replace('/listar');
                    }
                }).catch(err =>{
                  swal(`Oops! ocurrió un error intentando remover a ${name}.`);
                  console.log(err);
                });
        } else {
          swal("No se ha removido nada.");
        }
      });
};