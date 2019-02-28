package com.dhu.love.project.service;

import com.dhu.love.project.entity.Datemanager;

public interface DatemanagerService {
    Datemanager addDate(Datemanager datemanager);
    Datemanager updateDate(Datemanager datemanager);
    Datemanager deleteDate(Datemanager datemanager);
    Datemanager findDate(Datemanager datemanager);
}
