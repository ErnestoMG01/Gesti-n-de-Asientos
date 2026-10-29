# Sistema de Gestión de Asientos 

Sistema de consola desarrollado en Java basado en Programación Orientada a Objetos (POO) y estructuras de datos dinámicas (`List`) para gestionar la asignación de espacios y auditar el uso de equipo físico.

## 📌 Características Principales
- **Registro Permanente:** Carga de un padrón inicial de 30 estudiantes mediante una clase auxiliar (`CargadorAlumnos`), manteniendo limpio el archivo principal.
- **Asignación Manual Diaria:** Mapeo iterativo que vincula objetos `Estudiante` con objetos `Asiento` para un día específico.
- **Auditoría de Fallas:** Búsqueda no destructiva en el historial para rastrear rápidamente qué alumno ocupó un equipo específico en una fecha determinada.
- **Validación de Colisiones:** Sistema de seguridad en tiempo de ejecución que previene la asignación duplicada de un mismo asiento en un mismo día.

## 🛠️ Estructuras de Datos y Arquitectura
El sistema prescinde de arreglos estáticos para el historial, implementando en su lugar colecciones de la interfaz `List` (`ArrayList`). Esto permite un crecimiento dinámico de los registros a lo largo del cuatrimestre sin desbordamientos de memoria, facilitando las búsquedas lineales para la auditoría de equipos dañados.

