function eliminar({id, name}) {
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