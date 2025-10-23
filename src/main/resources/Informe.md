# Recursos del sistema

## Comando ps

```text
    PID TTY          TIME CMD
  32204 pts/3    00:00:00 bash
 106329 pts/3    00:00:00 java
 106348 pts/3    00:00:00 ps
```

## Comando df

```text
Filesystem                    1K-blocks    Used Available Use% Mounted on
udev                            3983444       0   3983444   0% /dev
tmpfs                            803356     692    802664   1% /run
/dev/mapper/debian12--vg-root  23852880 5925052  16690836  27% /
tmpfs                           4016764   58068   3958696   2% /dev/shm
tmpfs                              5120       0      5120   0% /run/lock
/dev/sda1                        465124  211976    228214  49% /boot
/dev/mapper/debian12--vg-var    9509056 2736188   6268244  31% /var
/dev/mapper/debian12--vg-tmp    1880592   25032   1741692   2% /tmp
/dev/mapper/debian12--vg-home 219851752 6626240 201984860   4% /home
tmpfs                            803352      36    803316   1% /run/user/1000
```

## Comando free

```text
               total        used        free      shared  buff/cache   available
Mem:         8033528     6908060      219248      106636     1282252     1125468
Swap:         999420       11848      987572
```
