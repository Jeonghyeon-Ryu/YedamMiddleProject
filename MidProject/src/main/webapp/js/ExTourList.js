/**
 * 
 */
 
 
 $('').click(function(){
         $.ajax({
            type:"POST",
            url:"exTourList.do",
            dataType:"json",
            data:{"" : ""},
            success:function(req){
               for(let i =0; i<req.length; i++){
               }
            },
            error:function(er){
               console.log("실패원인 : "+er);
            }
         });
      });