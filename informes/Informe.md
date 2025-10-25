# Recursos del sistema

## Comando ps

```text
    PID TTY          TIME CMD
   5943 pts/3    00:00:00 bash
   7412 pts/3    00:00:00 java
   7431 pts/3    00:00:00 ps
```

## Comando df

```text
Filesystem                    1K-blocks    Used Available Use% Mounted on
udev                            3983448       0   3983448   0% /dev
tmpfs                            803356     688    802668   1% /run
/dev/mapper/debian12--vg-root  23852880 5925052  16690836  27% /
tmpfs                           4016768   89276   3927492   3% /dev/shm
tmpfs                              5120       0      5120   0% /run/lock
/dev/mapper/debian12--vg-var    9509056 2760788   6243644  31% /var
/dev/sda1                        465124  211976    228214  49% /boot
/dev/mapper/debian12--vg-tmp    1880592    5504   1761220   1% /tmp
/dev/mapper/debian12--vg-home 219851752 7019384 201591716   4% /home
tmpfs                            803352      32    803320   1% /run/user/1000
```

## Comando free

```text
               total        used        free      shared  buff/cache   available
Mem:         8033536     7285600      277284      123960      851480      747936
Swap:         999420      263268      736152
```
