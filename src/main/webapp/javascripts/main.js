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
        skills.displaySource = 'panel';
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
                    alert(len);
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
                    skills.render(response);
                },
                error : function(response, textStatus, jqXHR){
                    skills.render('error');
                }
            });
        },
        skills.render = function(result){
            skills.result = result;
            alert('type '+ skills.type);
            alert('result '+result);
        },
        skills.syntax = {
            highlight : function(code){
                if(skills.media.indexOf('json')){
                    skills.syntax.transformJSON()
                }else if(skills.media.indexOf('xml')){
                    
                }
            },
            transformJSON: function(code){
                return (code.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;')).replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
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
                    return '<span class="' + cls + '">' + match + '</span>';
                });
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