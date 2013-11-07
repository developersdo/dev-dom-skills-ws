var devdom = null;

devdom = (function( $, undefined ){
        
    var skills = {};
        skills.JSON = new Array();
        skills.service  = 'http://skills-devdom.herokuapp.com/api';
        skills.resource = '';
        skills.type = 'GET';
        skills.media = 'json';
        skills.params = '';
        skills.result = '';
        skills.stringFormatted = '';
        skills.displaySource = 'source-code';
        skills.displaySourceAnk = '#ank';
        skills.path = '';
        skills.keyPath = '';
        skills.picture = {
            xOffset : 10,
            yOffset : 30,
            renderLink : function(){
                $("a.profile-picture").hover(function(e){
                    this.t = this.title;
                    this.title = "";	
                    var c = (this.t != "") ? "<br/>" + this.t : "";
                    $("body").append("<p id='profile-picture'><img src='"+ this.href +"'/>"+ c +"</p>");								 
                    $("#profile-picture") 
                            .css("top",(e.pageY - skills.picture.xOffset) + "px")
                            .css("left",(e.pageX + skills.picture.yOffset) + "px")
                            .fadeIn("fast");						
                },
                function(){
                    this.title = this.t;	
                    $("#profile-picture").remove();
                });	
                $("a.profile-picture").mousemove(function(e){
                    $("#profile-picture")
                        .css("top",(e.pageY - skills.picture.xOffset) + "px")
                        .css("left",(e.pageX + skills.picture.yOffset) + "px");
                });
            }
        };
        skills.category = {
            findAll : function(callback){
                skills.resource='/category';
                callback(skills.read());
            },
            findAllByPage : function(page,callback){
                skills.resource='/category/page/'+page;
                skills.read(callback);
            },
            show : function(){
                this.load(function(json){
                    var len = json['category'].length;
                });
            }
        };
        skills.icurl = function(url){
            if(url.length>0){
                skills.resource = url.split('api')[1];
                skills.read();
            }
        },skills.curl = function(url,target){
            if(url.length>0){
                skills.displaySourceAnk = target+"-ank";
                skills.displaySource = target;
                skills.resource = url.split('api')[1];
                skills.read();
            }
        }
        ,
        skills.read = function(){
            jQuery.support.cors = true;
            var result;
            $.ajax({ 
                url: (this.service + this.resource),
                type: this.type,
                dataType: this.media,
                data: this.params,
                success: function(response, textStatus, jqXHR){
                    skills.setResult(response);
                    skills.syntax.highlight();
                    jQuery('html,body').animate({
                                                scrollTop: $('#'+skills.displaySourceAnk).offset().top - 165
                                                },
                                                'slow');
                },
                error : function(response, textStatus, jqXHR){
                    skills.setResult('error');
                    alert('error:'+response)
                }
            });
        },
        skills.setResult = function(result){
            skills.result = result;
        },
        skills.getResult = function(){
            return skills.result;
        }
        ,
        skills.syntax = {
            nodeId : 0,
            header : '',
            createLinkage : function(prev,current){
                
                skills.syntax.defineHeader(current);

                var arrays = skills.resource.split('/',5);
                skills.path = arrays[1];
                skills.keyPath = arrays[3];
                var segment = '';
                
                function createLinks(prev,current,path,segment){
                    if(prev==='"id":'){
                        skills.syntax.nodeId = current;
                        return('<a href="javascript:devdom.curl(\''+(skills.service + 
                               '/'+path+'/id/'+skills.syntax.nodeId)+
                               '\',\''+skills.displaySource+'\');">'+skills.syntax.nodeId+'</a>');
                    }
                    if(prev==='"skills":' && skills.path==='category'){
                        return('<a href="javascript:devdom.curl(\''+(skills.service + 
                               '/skill/by/category/id/'+skills.syntax.nodeId)+
                               '\',\''+skills.displaySource+'\');">'+current+'</a>'); 
                    }
                    if(prev==='"votes":' && skills.path==='skill'){
                        return('<a href="javascript:devdom.curl(\''+(skills.service + 
                               '/developer/by/skill/id/'+skills.syntax.nodeId)+
                               '\',\''+skills.displaySource+'\');">'+current+'</a>'); 
                    }
                    if(prev==='"votes":' && skills.path==='developer'){
                        return('<a href="javascript:devdom.curl(\''+(skills.service + 
                               '/developer/by/skill/id/'+skills.syntax.nodeId)+
                               '\',\''+skills.displaySource+'\');">'+current+'</a>'); 
                    }
                    if(prev==='"skills":' && skills.path==='developer'){
                        return('<a href="javascript:devdom.curl(\''+(skills.service + 
                               '/skill/by/category/id/'+skills.syntax.nodeId)+
                               '\',\''+skills.displaySource+'\');">'+current+'</a>'); 
                    }
                    if(prev==='"picture":' && skills.path==='developer'){
                        return('<a target="_blank" href="'+current.replace(/"/g,'')+'" class="profile-picture">'+current+'</a>'); 
                    }
                    return current;
                }

                if(((skills.resource.replace(/\//,'')).indexOf('category')===0) ||
                   ((skills.resource.replace(/\//,'')).indexOf('skill')===0) ||
                   ((skills.resource.replace(/\//,'')).indexOf('developer')===0)
                  ){
                        if(skills.syntax.header==='pagination'){
                            if(prev==='"url":'){
                                return ('<a href="javascript:devdom.curl(\''+current.replace(/"/g,'')+'\',\''+skills.displaySource+'\');">'+current+'</a>');
                            }
                            if(prev==='"absolutePath":'){
                                return ('<a href="javascript:devdom.curl(\''+current.replace(/"/g,'')+'\',\''+skills.displaySource+'\');">'+current+'</a>');  
                            }
                        }else if(skills.syntax.header==='category'){
                            return createLinks(prev,current,'category','skill');
                        }else if(skills.syntax.header==='skill'){
                            return createLinks(prev,current,'skill','skill');
                        }else if(skills.syntax.header==='developers'){
                            return createLinks(prev,current,'developer','developer');
                        }
                        return current;
                    }
                    return current;
            },
            defineHeader : function(value){
                switch(value){
                    case '"category":'  : skills.syntax.header='category';break;
                    case '"pagination":': skills.syntax.header='pagination';break;
                    case '"skills":'    : skills.syntax.header='skill';break;
                    case '"developers":': skills.syntax.header='developers';break;
                }
            },
            highlight : function(){
                if(skills.media.indexOf('json')!==-1){
                    skills.syntax.transformJSON(skills.getResult());
                }else if(skills.media.indexOf('xml')){
                    // pendiente
                }
            },
            transformJSON: function(code){
                code = JSON.stringify(code, undefined, 4);
                code = code.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
                var previousTag = '';
                code = code.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
                    var cls = 'number';
                    if (/^"/.test(match)) {
                        if (/:$/.test(match)) {
                            cls = 'key';
                        } else {
                            cls = 'string';
                        }
                    } else if (/true|false/.test(match)) {
                        cls = 'boolean';
                    } else if (/null/.test(match)) {
                        cls = 'null';
                    }

                    var link = skills.syntax.createLinkage(previousTag,match);
                    previousTag = match;
                    return '<span class="' + cls + '">' + link + '</span>';
                });
                skills.setResult(code);
                $('#'+skills.displaySource).html("<pre>\n"+code+"\n</pre>");
                skills.picture.renderLink();
            },
            transformXML : function(){
                code = code.split('&').join('&');
                code = code.split('<').join('<');
                code = code.split('>').join('>');
            }
        },
        skills.init = function() {
            skills.category.show();
        };
        return skills;
    }( jQuery ));
    
jQuery.support.cors = true;