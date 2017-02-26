package com.bruce.intellijpluin.stackoverflow;

import com.intellij.ide.browsers.BrowserLauncher;
import com.intellij.ide.browsers.WebBrowserManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import org.apache.commons.lang.StringUtils;

/**
 * @Author bruce.ge
 * @Date 2017/2/26
 * @Description
 */
public class GoStackOverflow extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        String googleSite = "https://www.google.com/";
        CaretModel caretModel = e.getData(LangDataKeys.EDITOR).getCaretModel();
        Caret currentCaret =
                caretModel.getCurrentCaret();
        String selectedText = currentCaret.getSelectedText();
        if (StringUtils.isNotBlank(selectedText)) {
            BrowserLauncher.getInstance().browse(googleSite + "?#newwindow=1&q=site:stackoverflow.com " + selectedText + "&*", WebBrowserManager.getInstance().getFirstActiveBrowser());
        } else {
            System.out.println("select text is empty");
        }
    }
}
