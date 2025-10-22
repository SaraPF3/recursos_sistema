# Recursos del sistema

## Líneas que obtiene ps

Se muestran los procesos en ejecución.

----------------------------

    PID TTY          TIME CMD
   5454 pts/3    00:00:00 bash
  34361 pts/3    00:00:00 java
  34380 pts/3    00:00:00 ps

----------------------------

## Líneas que obtiene ds

Se muestra información sobre el espacio utilizado y el espacio disponible de todos los sistemas de archivos montados.

----------------------------

Filesystem                    1K-blocks    Used Available Use% Mounted on
udev                            3983448       0   3983448   0% /dev
tmpfs                            803356     688    802668   1% /run
/dev/mapper/debian12--vg-root  23852880 5914124  16701764  27% /
tmpfs                           4016768   89848   3926920   3% /dev/shm
tmpfs                              5120       0      5120   0% /run/lock
/dev/sda1                        465124  211976    228214  49% /boot
/dev/mapper/debian12--vg-home 219851752 6378472 202232628   4% /home
/dev/mapper/debian12--vg-tmp    1880592    1172   1765552   1% /tmp
/dev/mapper/debian12--vg-var    9509056 2730620   6273812  31% /var
tmpfs                            803352      28    803324   1% /run/user/1000

----------------------------

## Líneas que obtiene free

Se muestra información sobre el uso de la memoria del sistema.

----------------------------

               total        used        free      shared  buff/cache   available
Mem:         8033536     6615776      234524      142452     1602956     1417760
Swap:         999420           0      999420

----------------------------
