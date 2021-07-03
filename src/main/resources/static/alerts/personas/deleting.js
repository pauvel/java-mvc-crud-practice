/**
 * Deletes from database a person.
 * 
 * @param {id} id The person Id.
 * @param {name} name The person name.
 */
function eliminar({id, name}) {
    swal({
        title: "Seguro?",
        text: `Desea eliminar a ${name}?`,
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then(async (willDelete) => {

        if (willDelete) {
            await fetch(`/eliminar/${id}`)
              .then(deleted => {
                console.log(deleted);
                if(deleted.ok && deleted.redirected && deleted.status === 200){
                  swal(`Poof! la persona ${name} fue removida.`, {
                    icon: "success",
                  }).then(isOk =>{
                    window.location.replace('/listar');
                  });
                }else{
                  swal(`Ha ocurrido un error intentando eliminar a la persona.`, {
                    icon: "warning",
                  });
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

const eliminarPersona = (persona) => {
  eliminar(persona);
};

export{
  eliminarPersona
};