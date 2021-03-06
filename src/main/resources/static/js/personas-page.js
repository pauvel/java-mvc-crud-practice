import { eliminarPersona } from '../alerts/personas/deleting.js';
import { typeErrorAlert } from '../alerts/exceptions/typeExceptions.js';


const deleteUserButtons = document.querySelectorAll('table[name="users"] td a[name="deleteButton"]');

/**
 * Load events for /listar page.
 */
const events = () => {

    if(deleteUserButtons === typeof(undefined)  || deleteUserButtons === null){
        typeErrorAlert({
            title: 'Oops!..',
            text: 'Algo salio mal y no se pudo leer la informacion de la tabla.'
        });
        return;
    }

    if(deleteUserButtons.length === 0){
        typeErrorAlert({
            title: 'Oops!..',
            text: 'No hay usuarios existentes.'
        });
        return;
    }

    console.log('%c Botónes DELETE en la tabla:', 'font-size: large; color: red;')
    console.table(deleteUserButtons);
    
    /**
     * GET DELETE BUTTONS IN TABLE.
     */
    deleteUserButtons.forEach(button => {
        /**
         * Make click event for each delete button in table.
         */
        button.addEventListener('click', (event) => {
            // Get row [Parent of the button].
            const row = event.target.parentNode.parentNode;
            console.log('%c Row del botón presionado:', 'font-size: large; color: purple;')
            console.log(row);
            
             // Get <td> text by name.
            let personId = row.children.personId.innerText;
            let personName = row.children.personName.innerText;

            if(!isNaN(personId)) {

                const persona = {
                    id: personId,
                    name: personName
                }

                console.log(`%c Usuario a eliminar:`, 'font-size: 15px; color: red;')
                console.table(persona);
                // Execute delete person alert.
                eliminarPersona(persona);

            }else{
                // execute error alert.
                typeErrorAlert({
                    title: 'Error!',
                    text: `El id "${personId}" recibido, no pudo ser procesado porque no tiene el formato correcto.`
                });
            }

        })
    });

};

/**
 * Initialize personas-page.js module.
 */
const loadPersonasPage = () => {
    events();
}

export{
    loadPersonasPage,
}