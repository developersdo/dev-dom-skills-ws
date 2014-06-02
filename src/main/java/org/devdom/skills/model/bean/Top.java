package org.devdom.skills.model.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.devdom.skills.model.dao.SkillsDao;
import org.devdom.skills.model.dto.Skills;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@ManagedBean
@SessionScoped
public class Top implements Serializable{

    private static final long serialVersionUID = 1L;
    private final SkillsDao dao = new SkillsDao();

    public List<Skills> getSkills(){
        return dao.findAllSkillsByTopFilters(0,0,10);
    }
    
    public List<Skills> getLanguages(){
        return dao.findAllSkillsByTopFilters(5,0,10);
    }
    
    private List<Skills> getPopularLanguagesByUniversityId(){
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        int universityId = Integer.parseInt(request.getParameter("university-id"));

        return dao.findPopularLanguagesByUniversityId(universityId);
    }

    private List<Skills> getPopularSkillsByUniversityId(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String,String> request = externalContext.getRequestParameterMap();
        
        int universityId = Integer.parseInt(request.get("university-id"));
        return dao.findPopularSkillsByUniversityId(universityId);
    }
    
    /**
     * Listado de skills según el id de la universidad
     * @return 
     */
    public String getGraphPopularSkillsByUniversityId(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String,String> request = externalContext.getRequestParameterMap();
        String html;
        int universityId = Integer.parseInt(request.get("university-id"));
        List<Skills> skills = dao.findPopularSkillsByUniversityId(universityId);
        
        html = "<script language=\"javascript\">\n" +
"            var chart;\n" +
"            var data = [];\n" +
"            var newSkill = null;\n";
        for(Skills skill : skills){
            html+= "newSkill  = {\"skill\":\""+skill.getName()+"\",\"votes\":\""+skill.getVotes()+"\"};\n";
            html+= "data.push(newSkill)\n";
        }

        html +="         legend = new AmCharts.AmLegend();\n" +
            "            legend.align = \"center\";\n" +
            "            legend.markerType = \"square\";\n" +
            "\n" +
            "            chart = new AmCharts.AmPieChart();\n" +
            "            chart.dataProvider = data;\n" +
            "            chart.titleField = \"skill\";\n" +
            "            chart.valueField = \"votes\";\n" +
            "            chart.sequencedAnimation = true;\n" +
            "            chart.startEffect = \"elastic\";\n" +
            "            chart.innerRadius = \"30%\";\n" +
            "            chart.startDuration = 2;\n" +
            "            chart.labelRadius = 15;\n" +
            "            chart.balloonText = '[[title]]<br/><span style=\"font-size:14px\"><b>[[value]]</b> ([[percents]]%)</span>';\n" +
            "            chart.depth3D = 20;\n" +
            "            chart.angle = 35;\n" +
            "            chart.balloonText = '[[title]]<br/><span style=\"font-size:14px\"><b>[[value]]</b> ([[percents]]%)</span>';\n" +
            "            \n" +
            "            AmCharts.ready(function () {\n" +
            "                chart.addLegend(legend);\n" +
            "                chart.write(\"chart\");\n" +
            "            });\n" +
            "        </script>\n";
        html += "<div id=\"chart\" style=\"width: 100%; height:500px;\"></div>";
        return html;
    }
    /**
     * Gráfica que representa los lenguajes más populares entre los developers
     * @return 
     */
    public String getGraphPopularLanguages(){
        List<Skills> listLanguages = this.getLanguages();
        int len = listLanguages.size();
        String html;
        
        html =  "<p>\n" +
                "   En la gráfica se muestran los "+len+" lenguajes más votados\n" +
                "   <script language=\"javascript\">\n" +
                "       var chartLanguages;\n" +
                "       var chartData = [];\n" +
                "       var newSkill = null;\n" +
                "       \n";

        for(Skills language : listLanguages){
            html+= "newSkill  = {\"skill\":\""+language.getName()+"\",\"votes\":\""+language.getVotes()+"\"};\n";
            html+= "chartData.push(newSkill)\n";
        }

        html +="legendLanguages = new AmCharts.AmLegend();\n" +
        "       legendLanguages.align = \"center\";\n" +
        "       legendLanguages.markerType = \"square\";\n" +
        "       chartLanguages = new AmCharts.AmPieChart();\n" +
        "       chartLanguages.dataProvider = chartData;\n" +
        "       chartLanguages.titleField = \"skill\";\n" +
        "       chartLanguages.valueField = \"votes\";\n" +
        "       chartLanguages.sequencedAnimation = true;\n" +
        "       chartLanguages.startEffect = \"elastic\";\n" +
        "       chartLanguages.innerRadius = \"30%\";\n" +
        "       chartLanguages.startDuration = 2;\n" +
        "       chartLanguages.labelRadius = 15;\n" +
        "       chartLanguages.balloonText = '[[title]]<br/><span style=\"font-size:14px\"><b>[[value]]</b> ([[percents]]%)</span>';\n" +
        "       chartLanguages.depth3D = 20;\n" +
        "       chartLanguages.angle = 35;\n" +
        "       chartLanguages.balloonText = '[[title]]<br/><span style=\"font-size:14px\"><b>[[value]]</b> ([[percents]]%)</span>';\n" +
        "           \n" +
        "       AmCharts.ready(function () {\n" +
        "           chartLanguages.addLegend(legendLanguages);\n" +
        "           chartLanguages.write(\"chartLanguages\");\n" +
        "           chartSkills.addLegend(legendSkills);\n" +
        "           chartSkills.write(\"chartSkills\");\n" +
        "           \n" +
        "       });\n" +
        "   </script>\n" +
        "   <div id=\"chartLanguages\" style=\"width: 100%; height: 362px;\"></div>\n" +
        "</p>";
        return html;
    }
    
    /**
     * Gráfica que representa las habilidades más populares entre los developers
     * @return 
     */
    public String getGraphPopularSkills(){
    
        List<Skills> listSkills = this.getSkills();
        int len = listSkills.size();
        String html;

        html =  "<p>\n" +
                "  En la gráfica se muestran los "+ len +" skills más votados\n" +
                "<script language=\"javascript\">\n" +
                "   var chartSkills;\n" +
                "   var chartData = [];\n" +
                "   var newSkill = null;\n";

        for(Skills skill : listSkills){
            html+="newSkill  = {\"skill\":\""+skill.getName()+"\",\"votes\":\" "+skill.getVotes()+" \"};\n";
            html+="chartData.push(newSkill)\n";
        }

        html += "\n" +
                "legendSkills = new AmCharts.AmLegend();\n" +
                "legendSkills.align = \"center\";\n" +
                "legendSkills.markerType = \"square\";\n" +
                "\n" +
                "chartSkills = new AmCharts.AmPieChart();\n" +
                "chartSkills.dataProvider = chartData;\n" +
                "chartSkills.titleField = \"skill\";\n" +
                "chartSkills.valueField = \"votes\";\n" +
                "chartSkills.sequencedAnimation = true;\n" +
                "chartSkills.startEffect = \"elastic\";\n" +
                "chartSkills.innerRadius = \"30%\";\n" +
                "chartSkills.startDuration = 2;\n" +
                "chartSkills.labelRadius = 15;\n" +
                "chartSkills.balloonText = '[[title]]<br/><span style=\"font-size:14px\"><b>[[value]]</b> ([[percents]]%)</span>';\n" +
                "chartSkills.depth3D = 20;\n" +
                "chartSkills.angle = 35;\n" +
                "chartSkills.balloonText = '[[title]]<br/><span style=\"font-size:14px\"><b>[[value]]</b> ([[percents]]%)</span>';\n" +
                "</script>\n" +
                "<div id=\"chartSkills\" style=\"width: 100%; height: 362px;\"></div>\n" +
                "</p>";

        return html;
    }

}