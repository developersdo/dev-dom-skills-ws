package org.devdom.skills.model.dto;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public class Resource{

         int id;
         String uri;
         String pathRef;
         String tag;
         String description;

        public Resource(){

        }

        public Resource(int id, String uri, String pathRef, String tag, String description){
            this.id = id;
            this.uri = uri;
            this.pathRef = pathRef;
            this.tag = tag;
            this.description = description;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return the uri
         */
        public String getUri() {
            return uri;
        }

        /**
         * @param uri the uri to set
         */
        public void setUri(String uri) {
            this.uri = uri;
        }

        /**
         * @return the path
         */
        public String getPath() {
            return pathRef;
        }

        /**
         * @param path the path to set
         */
        public void setPath(String path) {
            this.pathRef = path;
        }

        /**
         * @return the tag
         */
        public String getTag() {
            return tag;
        }

        /**
         * @param tag the tag to set
         */
        public void setTag(String tag) {
            this.tag = tag;
        }

        /**
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description the description to set
         */
        public void setDescription(String description) {
            this.description = description;
        }
    }
