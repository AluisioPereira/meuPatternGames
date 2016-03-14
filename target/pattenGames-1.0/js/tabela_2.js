  
    $(document).ready(function() {
    var table = $('#tb1').DataTable();
     var valor = [];
     var cont = 0;
     var aux = 0;
     var vet = [];
    $('#tb1 tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
            $('#codCliente').val(data[0]);
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