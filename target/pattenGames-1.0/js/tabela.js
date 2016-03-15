  
    $(document).ready(function() {
    var table = $('#tb').DataTable();
     var valor = [];
     var cont = 0;
     var aux = 0;
     var vet = [];
    $('#tb tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        for (var i = 0; i < valor.length; i++){
            if (valor[i] == data[0]){
                aux = 1;
                for (var j = i; j < valor.length; j++){
                    valor[j] = valor[j+1];
                }
                valor.pop();
                
                cont--;
                $('#delete').val(valor);
                $('#editarCliente').val(data[0]);
                $('#cpf').val(data[0]);
                $('#nome').val(data[1]);
                $('#email').val(data[2]); 
            }
        }
        if (aux == 0){
            valor[cont] = data[0];
            cont++;

            $('#delete').val(valor);
            $('#editarCliente').val(data[0]);
            $('#cpf').val(data[0]);
            $('#nome').val(data[1]);
            $('#email').val(data[2]);        
        }  
        aux = 0;
    } );
} );




    $(document).ready(function(){
      $('.table tbody tr').click(function(){
        $trClass = $(this).attr('class');
        if ($trClass == undefined || $trClass == 'clicado'){
          $(this).attr('class', 'desclicado');
        } else {
          $(this).attr('class', 'clicado');
        }
      });
    });




/*

    $(document).ready(function(){
        var cont = 0;
        var dados = [];
        var aux = 0;
        $('tr').click(function(){
            

                
    var valorDaDiv = $(this).text(); 
    valor = valorDaDiv.split(" ");
    
         

     

    for (var a = 0; a <= valor.length; a++){

        if (dados[a] == valor[8]){
            
            aux = 1;
            
        } 
        

    
}
    if (aux == 0){
    dados[cont] = valor[8];
    

cont++;
        }
aux = 0;

    
});



    });

*/