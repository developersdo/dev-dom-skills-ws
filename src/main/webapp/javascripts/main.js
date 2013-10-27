var devdom = null;

devdom = (function( $, undefined ){
        
    var skills = {};
        skills.JSON = new Array();
        skills.service  = 'http://localhost:8080/api';
        skills.resource = '';
        skills.type = 'GET';
        skills.media = 'json';
        skills.params = '';
        skills.result = '';
        skills.stringFormatted = '';
        skills.displaySource = 'source-code';
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
                    var len = json["category"].length;
                });
            }
        };
        skills.read = function(callback){
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
                },
                error : function(response, textStatus, jqXHR){
                    skills.render('error');
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
                
                function createLink(prev,current){
                    if(prev==='"id":'){
                        skills.syntax.nodeId = current;
                        return('<a href="'+(skills.service + 
                               '/category/id/'+skills.syntax.nodeId)+
                               '">'+skills.syntax.nodeId+'</a>');
                    }else if(prev==='"skills":'){
                        return('<a href="'+(skills.service + 
                               '/skill/by/category/id/'+skills.syntax.nodeId)+
                               '">'+current+'</a>'); 
                    }
                    return current;
                }
                
                if(((skills.resource.replace(/\//,'')).indexOf('category')===0)){
                    if(skills.syntax.header==='pagination'){
                        if(prev==='"url":')
                            return ('<a href="'+current.replace(/"/g,'')+'">'+current+'</a>');
                        if(prev==='"absolutePath":')
                            return ('<a href="'+current.replace(/"/g,'')+'">'+current+'</a>');  
                    }else{
                        return createLink(prev,current);
                    }
                }
                return current;
            },
            defineHeader : function(value){
                switch(value){
                    case '"category":': skills.syntax.header='category';break;
                    case '"pagination":': skills.syntax.header='pagination';break;
                    case '"skills":': skills.syntax.header='skills';break;
                }
            },
            highlight : function(){
                if(skills.media.indexOf('json')!==-1){
                    skills.syntax.transformJSON(skills.getResult());
                }else if(skills.media.indexOf('xml')){
                    
                }
            },
            transformJSON: function(code){
                code = JSON.stringify(code, undefined, 4);
                code = code.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
                var previousTag = '';
                var currentTag = '';
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

                    if(cls.indexOf("number")!==0){
                        
                    }
                    var link = skills.syntax.createLinkage(previousTag,match);
                    previousTag = match;
                    return '<span class="' + cls + '">' + link + '</span>';
                });
                skills.setResult(code);
                $('#'+skills.displaySource).html("<pre>\n"+code+"\n</pre>");
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
    
    //devdom.category.