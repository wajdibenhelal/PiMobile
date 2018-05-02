/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.uikit.materialscreens;

import com.codename1.components.ToastBar;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.gui.BabySitter;
import com.pofper.maps.entity.Point;

/**
 * Common code that can setup the side menu
 *
 * @author Shai Almog
 */
public abstract class SideMenuBSForm extends Form {

    public SideMenuBSForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBSForm(String title) {
        super(title);
    }

    public SideMenuBSForm() {
    }

    public SideMenuBSForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
              Image profilePic = res.getImage("");
        
        Label profilePicLabel = new Label("", profilePic, "SideMenuTitle");

        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
     
        getToolbar().addComponentToSideMenu(sidemenuTop);
        getToolbar().addMaterialCommandToSideMenu("  Profile", FontImage.MATERIAL_MESSAGE,  e -> new AffichageBlague(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Message", FontImage.MATERIAL_RECEIPT,  e -> new AffichageRecette(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Parameter", FontImage.MATERIAL_ACCESS_TIME,  e -> new AffichageBonplan(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Conseils", FontImage.MATERIAL_CONTACTS,  e -> new AffichageConseil(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Utilisateur", FontImage.MATERIAL_INFO,  e -> new AffichageUser(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  e -> new LoginForm(res).show());
   
        getToolbar().addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_HOME, e -> {
            //  Form profilForm = 

        });
        getToolbar().addMaterialCommandToSideMenu("BabySitter", FontImage.MATERIAL_WEB, e -> {
            Form recommandationListForm = (new BabySitter(new Point(36.872530, 10.316018), 3000, 200, 200))
                    .getContainer();
            recommandationListForm.show();
             });
        
       
        }
    
    protected abstract void showOtherForm(Resources res);
}