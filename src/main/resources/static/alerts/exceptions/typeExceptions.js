const typeErrorAlert = ({title, text}) => {
    swal({
        icon: 'error',
        title,
        text
      })
};

export{
    typeErrorAlert
}