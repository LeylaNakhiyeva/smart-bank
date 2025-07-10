package org.example.strategy.userStrategy;

import org.example.strategy.MenuStrategy;
import org.example.utils.MenuUtil;

public class LogoutStrategy implements MenuStrategy {
    @Override
    public void execute() {
        MenuUtil.baseMenu();
    }
}
