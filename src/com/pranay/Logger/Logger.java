package com.pranay.Logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

enum LogLevel {
    INFO,
    DEBUG,
    ERROR
}

// Main class should be named 'Solution'
class Solution {
    public static void main(String[] args) {
        String tsFormat = "dd­mm­yyyy­hh­mm­ss";
        String logLevel = "INFO";
        String sinkType = "FILE";
        String filePath = "/var/log/app/info.log";

        Sink sink;
        switch(sinkType) {
            case "FILE":
                sink = new FileSink(tsFormat, logLevel, filePath);
                break;
            default :
                throw new SinkTypeNotFoundException();
        }

        Logger logger = SimpleLogger.getInstance(sink).setNamespace("main.class");
        logger.log("First log");
    }
}

interface Sink {
    public void push(String namespace, String msg);
    public String format(String namespace, String msg);
}

class FileSink implements Sink {
    String logLevel;
    String fileLocation;
    BlockingQueue<String> q;

    File file;
    FileWriter stream;
    SimpleDateFormat sdt;

    public FileSink(String tsFormat, String logLevel, String fileLocation) {
        this.logLevel = logLevel;
        this.fileLocation = fileLocation;
        this.sdt = new SimpleDateFormat(tsFormat);

        this.file = new File(fileLocation);
        this.q = new LinkedBlockingQueue<>();
        new Thread(new Consumer(q, stream)).start();

        try {
            file.createNewFile();
            this.stream = new FileWriter(file);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void push(String namespace, String msg) {
        String formattedText = this.format(namespace, msg);
        System.out.println("here to push to sink - " + formattedText);
        q.add(formattedText);
    }

    public String format(String namespace, String msg) {
        String date = sdt.format(new Date());
        return this.logLevel + " - " + date + " - " + " ("+ namespace +") " + msg;
    }
}

class Consumer implements Runnable {
    BlockingQueue<String> q;
    FileWriter writer;

    public Consumer(BlockingQueue<String> q, FileWriter writer) {
        this.q = q;
        this.writer = writer;
    }

    public void run() {
        while (true) {
            try {
                String msg = q.poll();
                writer.write(msg);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

abstract class Logger {
    String namespace;
    Sink sink;

    public Logger(Sink sink) {
        this.sink = sink;
    }

    public abstract void log(String msg);
}

class  SimpleLogger extends Logger {
    private static SimpleLogger instance = null;
    String namespace;

    private SimpleLogger(Sink sink) {
        super(sink);
        namespace = "default";
    }

    public static SimpleLogger getInstance(Sink sink) {
        if (instance == null) {
            instance = new SimpleLogger(sink);
        }
        return instance;
    }

    public void log(String msg) {
        sink.push(namespace, msg);
    }

    public SimpleLogger setNamespace(String ns) {
        namespace = ns;
        return instance;
    }
}

class SinkTypeNotFoundException extends RuntimeException {}