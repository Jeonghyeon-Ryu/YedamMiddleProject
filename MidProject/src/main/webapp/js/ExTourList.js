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
                  let table = "<tr>";
                  table+="<td rowspan='2'><div class='list-icon'><label for="+req[i].id+">🎵</label></div></td>";
                  table+="<td><div class='list-row'><label for="+req[i].id+">&nbsp&nbsp&nbsp"+req[i].title+"</label></div></td>";
                  table+="<td rowspan='2'><div class='list-icon'><label for="+req[i].id+">🥒x3</label></div></td>";
                  table+="<td rowspan='2'><div class='list-icon'><input id="+req[i].id+" name='music' value="+req[i].id+" type='checkbox' onclick='checkMusic()'' /></div></td>";
                  table+="</tr><tr>";
                  table+="<td><div class='list-row'><label for="+req[i].singer+">&nbsp&nbsp&nbsp"+req[i].singer+"</label></div></td></tr>";
                  $('#musicTable').append(table);         
               }
            },
            error:function(er){
               console.log("실패원인 : "+er);
            }
         });
      });