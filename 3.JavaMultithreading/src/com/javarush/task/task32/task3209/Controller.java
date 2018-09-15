package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;


public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
    public void init(){
        createNewDocument();
    }
    public void exit(){
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }
    public void resetDocument(){
        if(document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
                htmlEditorKit.read(stringReader,document,0);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter,document,0,document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }
    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;


    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Open File");
        chooser.setFileFilter(new HTMLFileFilter());
        if(chooser.showOpenDialog(view) == JFileChooser.OPEN_DIALOG){
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try (FileReader reader = new FileReader(currentFile) ){
                htmlEditorKit.read(reader,document,0);
                view.resetUndo();

            } catch (UnsupportedEncodingException e) {
                ExceptionHandler.log(e);
            } catch (FileNotFoundException e) {
                ExceptionHandler.log(e);
            } catch (IOException e) {
                ExceptionHandler.log(e);;
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save File");
        chooser.setFileFilter(new HTMLFileFilter());
        if(chooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION){
            currentFile = chooser.getSelectedFile();
                    HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                  try (FileWriter writer = new FileWriter(currentFile) ){
                      htmlEditorKit.write(writer,document,0,document.getLength());
                      view.setTitle(currentFile.getName());
                } catch (UnsupportedEncodingException e) {
                    ExceptionHandler.log(e);
                } catch (FileNotFoundException e) {
                    ExceptionHandler.log(e);
                } catch (IOException e) {
                    ExceptionHandler.log(e);;
                } catch (BadLocationException e) {
                    ExceptionHandler.log(e);
                }
        }
        }
    public void saveDocument() {
    if(currentFile == null) saveDocumentAs();
    else {
        view.selectHtmlTab();
         HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try (FileWriter writer = new FileWriter(currentFile) ){
                htmlEditorKit.write(writer,document,0,document.getLength());
            } catch (UnsupportedEncodingException e) {
                ExceptionHandler.log(e);
            } catch (FileNotFoundException e) {
                ExceptionHandler.log(e);
            } catch (IOException e) {
                ExceptionHandler.log(e);;
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }

    }
    }
}
