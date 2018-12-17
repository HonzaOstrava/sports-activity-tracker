package cz.muni.fi.PA165.tracker.configuration;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Initializer for rest
 * @author pmikova 433345
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[]{RestContext.class};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return null;
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }

        @Override
        protected Filter[] getServletFilters() {
            CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
            encodingFilter.setEncoding("utf-8");
            encodingFilter.setForceEncoding(true);


            return new Filter[]{encodingFilter};
        }

        @Override
        public void onStartup(javax.servlet.ServletContext servletContext) throws javax.servlet.ServletException {
            super.onStartup(servletContext);
            servletContext.addListener(RequestContextListener.class);
        }

    }