package cn.server.lab;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.ToolboxFactory;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;

/**
 * Created by Fu Zhong on 2015/8/14.
 */
public class MyVelocityToolboxView extends VelocityToolboxView {

    @Override
    protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ViewToolContext velocityContext = new ViewToolContext(getVelocityEngine(), request, response, getServletContext());
        velocityContext.putAll(model);
        if (getToolboxConfigLocation() != null) {
            ToolManager toolManager = new ToolManager();
            toolManager.setVelocityEngine(getVelocityEngine());
            toolManager.configure(getServletContext().getRealPath(getToolboxConfigLocation()));
            ToolboxFactory factory = toolManager.getToolboxFactory();
            if (factory.hasTools(Scope.APPLICATION)) {
                velocityContext.addToolbox(factory.createToolbox(Scope.APPLICATION));
            }
            if (factory.hasTools(Scope.REQUEST)) {
                velocityContext.addToolbox(factory.createToolbox(Scope.REQUEST));
            }
            if (factory.hasTools(Scope.SESSION)) {
                velocityContext.addToolbox(factory.createToolbox(Scope.SESSION));
            }
        }
        return velocityContext;
    }

}
