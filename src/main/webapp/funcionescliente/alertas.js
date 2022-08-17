
$("#btn1, #btn2, #btn3, #btn4, #btn5, #btn6, #btn7, #btn8, #btn9, #btn10, #btn11, #btn12, #btn13, #btn14, #btn15, #btn16, #btn17, #btn18, #btn19, #btn20, #btn21, #btn22, #btn23, #btn24, #btn25, #btn26, #btn27, #btn28, #btn29").click(function(){

  Swal.fire({
    icon: 'warning',
    input: 'textarea',
    inputLabel: 'Descripción',
    inputPlaceholder: 'Escribe aquí por que quieres borrar esto',
    inputAttributes: {
      'aria-label': 'Type your message here'
    },
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    text: "Tu no puedes revertir tu elección!",
    confirmButtonText: 'Si, borralo!',
    showCancelButton: true
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire(
        'Borrado!',
        'Este elemento ha sido borrado.',
        'success'
        )
    }
  })
});




$("#bt1, #bt2, #bt3, #bt4, #bt5, #bt6, #bt7, #bt8, #bt9, #bt10, #bt11, #bt12, #bt13, #bt14, #bt15, #bt16, #bt17, #bt18, #bt19, #bt20, #bt21, #bt22, #bt23, #bt24, #bt25, #bt26, #bt27, #bt28, #bt29").click(function(){

  Swal.fire({
    icon: 'warning',
    input: 'textarea',
    inputLabel: 'Descripción',
    inputPlaceholder: 'Escribe aquí por que quieres archivar esto',
    inputAttributes: {
      'aria-label': 'Type your message here'
    },
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    text: "Este producto irá a la tabla de productos archivados!",
    confirmButtonText: 'Si, archivalo!',
    showCancelButton: true
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire(
        'Archivado!',
        'Este producto ha sido archivado.',
        'success'
        )
    }
  })
});




$("#b1, #b2, #b3, #b4, #b5").click(function(){
  Swal.fire({
    title: 'Estas seguro?',
    text: "Quieres borrar este producto de tu carrito?",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Si, borralo!'
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire(
        'Borrado!',
        'Este producto fue borrado del carrito.',
        'success'
        )
    }
  })
});






$("#borrototal").click(function(){
  Swal.fire({
    title: 'Estas seguro?',
    text: "Quieres vaciar tu carrito?",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Si, borralo!'
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire(
        'Vaciado!',
        'El carrito de compras fue vaciado totalmente.',
        'success'
        )
    }
  })
});





$("#boton1, #boton2, #boton3, #boton4, #boton5, #boton6, #boton7, #boton8, #boton9, #boton10, #boton11, #boton12, #boton13, #boton14, #boton15, #boton16, #boton17, #boton18, #boton19, #boton20, #boton21, #boton22, #boton23, #boton24, #boton25, #boton26, #boton27, #boton28, #boton29").click(function(){

  Swal.fire({
    title: 'Estas seguro?',
    text: "Activaras este producto de nuevo!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Si, activalo!'
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire(
        'Activado!',
        'Este producto vuelve a estar disponible, ya puedes modificarlo.',
        'success'
        )
    }
  })
});





function aceptarproveedores(){
  var nombre = document.getElementById("Nombres").value;
  var apellido = document.getElementById("Apellidos").value;
  var empresas = document.getElementById("empresa").value;
  var nits = document.getElementById("nit").value;
  var direccion = document.getElementById("direccion1").value;
  var correo = document.getElementById("correo1").value;
  var depar = document.getElementById("departamento").value;
  var ciudad1 = document.getElementById("ciudad").value;


  if (nombre === "" || apellido === "" || empresas === "" || nits === "" ||
    direccion === "" || correo === "" || depar === "" || ciudad1 === "") {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'Hay campos del formulario que están en blanco y deben ser llenados',
    });  
  return false; 
}else{
  Swal.fire({
    icon: 'success',
    title: 'Registrado',
    text: 'El registro del proveedor David Valbuena de la empresa SIOCA fue exitoso, el número de ID asignado fue 123',
  });
  return false;
}
};






function aceptarusuario(){
  var nombre = document.getElementById("Nombre").value;
  var apellido = document.getElementById("Apellidos").value;
  var identificacion = document.getElementById("identificacion").value;
  var numidenti = document.getElementById("numidenti").value;
  var direccion = document.getElementById("direccion1").value;
  var correo = document.getElementById("correo").value;
  var telefono = document.getElementById("tel").value;
  var fecha = document.getElementById("fecha").value;
  var contraseña = document.getElementById("contraseña").value;
  var contraseña1 = document.getElementById("contraseña1").value;
  var usuario = document.getElementById("usuario").value;


  if (nombre === "" || apellido === "" || identificacion === "" || numidenti === "" ||
    direccion === "" || correo === "" || telefono === "" || fecha === "" || contraseña === "" || contraseña1 === "" || usuario === "") {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'Hay campos del formulario que están en blanco y deben ser llenados',
    });  
  return false; 
}else{
  Swal.fire({
    icon: 'success',
    title: 'Registrado',
    text: 'El registro del nuevo usuario David Valbuena con rol de Administrador fue exitoso, el ID asignado fue el 324',
  });
  return false;
}
};





function aceptarpedido(){
  var metodo = document.getElementById('metodopago').value;
  var cantidad = document.getElementById("cantidad").value;
  var ref1 = document.getElementById("ref1").value;
  var ref2 = document.getElementById("ref2").value;
  var direccion = document.getElementById("direccion").value;
  var nombre = document.getElementById("nombrecliente").value;
  var vendedor = document.getElementById("nombrevendedor").value;


  if (nombre === "" || vendedor === "" || metodo === "" || cantidad === "" ||
    direccion === "" || ref1 === "" || ref2 === "") {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'Hay campos del formulario que están en blanco y deben ser llenados',
    });  
  return false; 
}else{
  Swal.fire({
    icon: 'success',
    title: 'Registrado',
    text: 'El registro del pedido fue exitoso, se le ha asignado el #20',
  });
  return false;
}
};





function aceptarsalida(){
  var ref1 = document.getElementById("ref1").value;
  var ref2 = document.getElementById("ref2").value;
  var razon = document.getElementById("razon").value;
  var adicional = document.getElementById("adicional").value;


  if (ref1 === "" || ref2 === "" || razon === "" || adicional === "" ) {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'Hay campos del formulario que están en blanco y deben ser llenados',
    });  
  return false; 
}else{
  Swal.fire({
    icon: 'success',
    title: 'Borrado',
    text: 'Se ha borrado el producto con referencia #123421 fue exitoso, que tenia asignado el ID #31',
  });
  return false;
}
};

function aceptarproducto(){
  var tipo = document.getElementById("tipo").value;
  var talla = document.getElementById("talla").value;
  var producto = document.getElementById("nombreproducto").value;
  var precio = document.getElementById("precioestimado").value;
  var referencia = document.getElementById("ref").value;
  var cantidad = document.getElementById("cantidad").value;
  var precio2 = document.getElementById("preciounidad").value;
  var fecha = document.getElementById("fecha").value;
  var idproveedor = document.getElementById("idproveedor").value;
  var idproveedor2 = document.getElementById("idproveedor2").value;


  if (tipo === "" || talla === "" || producto === "" || cantidad === "" ||
    precio === "" || precio2 === "" || referencia === "" || fecha === "" || idproveedor === "" || idproveedor2 === "") {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'Hay campos del formulario que están en blanco y deben ser llenados',
    });  
  return false; 
}else{
  Swal.fire({
    icon: 'success',
    title: 'Registrado',
    text: 'El registro del producto con referencia #123421 fue exitoso, se le ha asignado el ID #31',
  });
  return false;
}
};




function modificarproveedores(){
  var novedad = document.getElementById("novedad").value;

  if (novedad === "") {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'El campo de novedad está vacio y es obligatorio llenarlo',
    });
    return false;
  }else{
  Swal.fire({
    icon: 'success',
    title: 'Registrado',
    text: 'La modificación del proveedor David Valbuena con ID 123 fue exitoso, la información sera almacenada y actualizada',
  });
  return false;
}
};




function modificarproductos(){
  var novedad = document.getElementById("novedad").value;

  if (novedad === "") {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'El campo de novedad está vacio y es obligatorio llenarlo',
    });
    return false;
  }else{
  Swal.fire({
    icon: 'success',
    title: 'Añadido',
    text: 'La modificación del producto Jean Skinny con ID 123 fue exitoso, la información sera almacenada y actualizada',
  });
  return false;
}
};







function modificarpedidos(){
  var novedad = document.getElementById("novedad1").value;

  if (novedad === "") {
    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'El campo de novedad está vacio y es obligatorio llenarlo',
    });
    return false;
  }else{
  Swal.fire({
    icon: 'success',
    title: 'Registrado',
    text: 'La modificación del pedido #123 fue exitoso, la información sera almacenada y actualizada',
  });
  return false;
}
};






$('#btnpagar').click(function(){
  Swal.fire({
    title: 'Seleccionar metodo de pago',
    input: 'select',
    inputOptions: {
      efectivo: 'Efectivo',
      nequi: 'Nequi',
      daviplata: 'Daviplata',
      tarjetadebito: 'Tarjeta Debito',
      tarjetacredito: 'Tarjeta Crédito'
    },
    inputPlaceholder: 'Selecciona',
    showCancelButton: true,
    inputValidator: (value) => {
      return new Promise((resolve) => {
        if (value === '') {
          resolve('Debes seleccionar un método de pago')
        }else {
          if (value === 'nequi') { 
            Swal.fire({
              imageUrl: 'https://play-lh.googleusercontent.com/J2CfzgROe1_weYm7yNIffrAGsGeahADM6r2qMN3C9pNw-i0TJR71LGbVX9y2N7t6dw',
              imageWidth: 400,
              imageHeight: 300,
              imageAlt: 'Custom image',
              title: 'Nequi',
              text: 'El número de la cuenta es 3144241394'
            })
          } 
          if (value === 'efectivo') {
            Swal.fire({
              imageUrl: 'https://www.wradio.com.co/resizer/8MN565PtntsL5SHBDj9BjNnO4K8=/1440x1440/filters:format(jpg):quality(70)/cloudfront-us-east-1.images.arcpublishing.com/prisaradioco/A6EOAGR36FEIZJPSAONNJVXJZU.jpg',
              imageWidth: 400,
              imageHeight: 300,
              imageAlt: 'Custom image',
              title: 'Efectivo',
              text: 'Se te cobrará el pedido en el momento de la entrega'
            })
          }
          if (value === 'daviplata') {
            Swal.fire({
              imageUrl: 'https://pbs.twimg.com/profile_images/1278486201096384513/PMQTXUUA_400x400.png',
              imageWidth: 400,
              imageHeight: 300,
              imageAlt: 'Custom image',
              title: 'Daviplata',
              text: 'El número de la cuenta es 3107722270'
            })
          } 
          if (value === 'tarjetadebito'){
            Swal.fire({
              imageUrl: 'https://www.visa.com.co/dam/VCOM/regional/lac/SPA/Default/Pay%20With%20Visa/Tarjetas/visa-debit-gold-400x225.jpg',
              imageWidth: 450,
              imageHeight: 300,
              imageAlt: 'Custom image',
              title: 'Tarjeta Debito',
              text: 'Debes tener la tarjeta debito en el momento de la entrega, el repartidor llevará datafono, gracias!'
            })
          }
          if (value === 'tarjetacredito'){
            Swal.fire({
              imageUrl: 'https://www.bbva.com.co/content/dam/public-web/colombia/images/blog/tarjetas/cual-es-numero-de-tarjeta-de-credito.png.img.1600.1598289581557.png',
              imageWidth: 400,
              imageHeight: 300,
              imageAlt: 'Custom image',
              title: 'Tarjeta Credito',
              text: 'Debes tener la tarjeta credito y la cédula del titular en el momento de la entrega, el repartidor llevará datafono, gracias!'
            })
          }       
        }
      })
    }
  })
});