# Maestranzas Unidos S.A. - Sistema de Control de Inventarios

Proyecto desarrollado para la implementación de una solución tecnológica escalable para la empresa Maestranzas Unidos S.A., especializada en la fabricación y mantenimiento de equipos pesados para la industria minera y de construcción en Copiapó, región de Atacama.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.3.12
- Oracle SQL (conexión via Wallet)
- Maven
- Visual Studio Code (Con extensiones Spring Boot Extension Pack y Extension Pack for Java)
- Postman (para pruebas de APIs)
- Spring Web (Para desarrollo de APIs REST)
- Lombok (Anotaciones para simplificación de código)
- Spring DATA JPA (Para persistencia de datos)
- Oracle Driver (Driver de conexión a Oracle)
- Spring Security (Para autenticación y autorización)

---

## Entidades implementadas

- **Usuario**: Administradores del sistema, gestores de inventario, compradores, encargados de logística, jefes de producción, auditores y usuarios finales.
- **Inventario**: Registro de piezas y componentes con información detallada.
- **Movimiento**: Seguimiento de entradas, salidas y transferencias de inventario.
- **Proveedor**: Gestión de proveedores y sus datos de contacto.
- **Kit**: Gestión de conjuntos de piezas utilizadas como un solo artículo.
- **Orden de Compra**: Automatización de órdenes basadas en niveles de inventario.

Cada entidad cuenta con:
- `@Entity` modelo de datos
- `@Repository` para acceso a datos
- `@RestController` para exponer APIs
- `DTO` para transporte de datos
- Servicios (`@Service`) para lógica de negocio

---

## Estructura del Proyecto y Microservicios

El proyecto está organizado de forma modular, simulando una arquitectura basada en microservicios por dominio funcional. Cada módulo (Inventario, Movimientos, Proveedores, Kits, Órdenes) cuenta con:

- Un controlador REST (`@RestController`)
- Un servicio de negocio (`@Service`)
- Un repositorio (`@Repository`)
- Su modelo de datos (`@Entity`)
- Su DTO para transferencia de datos

Esta estructura escalable permite una futura migración a una arquitectura de microservicios distribuida.

---

## Funcionalidades Principales

### Sistema de Alertas Automáticas
- Notificaciones cuando los niveles de stock alcanzan umbrales críticos
- Alertas de fechas de vencimiento para materiales con caducidad
- Notificaciones automáticas al equipo de aprovisionamiento

### Control de Movimientos en Tiempo Real
- Registro automático de entradas y salidas
- Seguimiento de transferencias internas
- Historial completo de movimientos por item

### Gestión Avanzada de Inventario
- Categorización y etiquetado personalizado
- Control de lotes y fechas de vencimiento
- Gestión de kits y conjuntos de piezas

### Integración con Sistemas de Compra
- Generación automática de órdenes de compra
- Gestión de proveedores integrada
- Historial de precios de compra

---

## Perfiles de Usuario

- **Administrador del Sistema**: Configuración y supervisión general
- **Gestor de Inventario**: Administración diaria del inventario
- **Comprador**: Gestión de compras y proveedores
- **Encargado de Logística**: Control de ubicaciones físicas
- **Jefe de Producción**: Coordinación de recursos para proyectos
- **Auditor de Inventario**: Verificación y auditorías periódicas
- **Gerente de Proyectos**: Asignación de recursos por proyecto
- **Usuario Final**: Solicitud y registro de uso de materiales

---

## Metodología Ágil - Scrum

El proyecto se desarrolla utilizando metodología Scrum con las siguientes ceremonias:

- **Daily Standup**: 1 vez por semana
- **Sprint Planning**: Cada 2 semanas
- **Sprint Review**: Al final de cada sprint
- **Retrospectiva**: Para mejora continua

### Roles del Equipo
- **Product Owner**: Representante de Maestranzas Unidos S.A.
- **Scrum Master**: Facilitador del proceso ágil
- **Development Team**: Equipo de desarrolladores full-stack

---

## Instalación

```bash
git clone https://github.com/tu-usuario/maestranzas-inventario.git
cd maestranzas-inventario
```

### Configuración de la Base de Datos

1. Configura la conexión a Oracle Cloud en `application.properties`:

```properties
spring.datasource.url=jdbc:oracle:thin:@TU_WALLET_DB_HIGH
spring.datasource.username=tu_usuario_BD
spring.datasource.password=tu_contraseña_BD
spring.jpa.hibernate.ddl-auto=update
```

2. Asegúrate de tener configurado el Wallet de Oracle correctamente.

### Ejecución de la Aplicación

```bash
./mvnw spring-boot:run
```

O ejecuta directamente desde tu IDE abriendo `MaestranzasInventarioApplication.java`

### Acceso a las APIs

```
http://localhost:8080/api/
```

---

## Pruebas de Funcionamiento

Las pruebas de las APIs fueron realizadas con **Postman**, verificando:

- Inserción de datos con `POST`
- Consulta de datos con `GET`
- Actualización de registros con `PUT`
- Eliminación de datos con `DELETE`
- Validación de respuestas correctas (status 200, 201, 204)
- Pruebas de seguridad y autorización
- Validación de alertas automáticas

---

## Cronograma del Proyecto (6 meses)

### Fase 1: Análisis y Diseño (Mes 1-2)
- Levantamiento funcional
- Identificación de historias de usuario
- Priorización del backlog (MoSCoW)
- Definición del MVP

### Fase 2: Desarrollo (Mes 3-5)
- Implementación de funcionalidades core
- Desarrollo de APIs REST
- Implementación de sistema de alertas
- Integración con sistema de compras

### Fase 3: Testing y Despliegue (Mes 6)
- Pruebas unitarias e integración
- Capacitación de usuarios
- Despliegue en producción
- Documentación final

---

## Propuesta de Workflow CI/CD

```yaml
name: CI Maestranzas Inventario

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
    - name: Clonar repositorio
      uses: actions/checkout@v3
      
    - name: Configurar Java 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
        
    - name: Ejecutar tests
      run: mvn test
      
    - name: Construir con Maven
      run: mvn clean install
      
    - name: Análisis de código con SonarQube
      run: mvn sonar:sonar
```

---

## Factores Clave de Éxito

- ✅ Comprensión profunda de los procesos de la maestranza
- ✅ Involucramiento activo de usuarios finales
- ✅ Definición clara y priorización de requerimientos
- ✅ Diseño de interfaz intuitiva y fácil de usar
- ✅ Implementación de metodología ágil Scrum
- ✅ Seguridad y privacidad de datos garantizada
- ✅ Escalabilidad para crecimiento futuro
- ✅ Comunicación efectiva entre stakeholders

---

## Equipo de Desarrollo

- **Product Owner**: Representante de Maestranzas Unidos S.A.
- **Scrum Master**: [Nombre del Scrum Master]
- **Tech Lead**: [Nombre del líder técnico]
- **Desarrolladores Full-Stack**: [Nombres del equipo]
- **QA Tester**: [Nombre del tester]

---

## Contacto

**Empresa**: Maestranzas Unidos S.A.  
**Ubicación**: Copiapó, Región de Atacama, Chile  
**Industria**: Fabricación y mantenimiento de equipos pesados  

---

## Notas Técnicas

- `spring.jpa.hibernate.ddl-auto=update` configurado para preservar datos en reinicio
- Dependencias Oracle recomendadas implementadas
- Sistema probado y funcional con Oracle Cloud via Wallet
- Respaldo automático configurado para continuidad operacional
- Logs de auditoría implementados para trazabilidad completa