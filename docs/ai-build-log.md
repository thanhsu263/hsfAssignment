# AI build log

## Phase 1 — Bootstrap setup and shared layout

Added exact Bootstrap 5.3.3 and Bootstrap Icons 1.11.3 WebJars in `pom.xml`. Created `templates/fragments/layout.html` for the shared head, responsive navbar, flash messages, footer, and scripts. Added a small `static/css/app.css` file and a localStorage-based dark/light theme toggle. The old pages were replaced by fragment-based layouts so head and navigation are not copied.

## Phase 2 — Bootstrap page design

Built the login card, dashboard, product list, and product form with Bootstrap components only. Added icons, responsive tables, empty states, validation feedback, low-stock badges, pagination, and a reusable delete modal. Templates use `currentUser.admin` so management buttons are visible only to admins. Files changed are under `src/main/resources/templates`.

## Phase 3 — Back-end behavior and security

Added service methods, pageable product search, low-stock counts, dashboard data, and POST deletion. Added `GlobalModelAdvice`, `LoginInterceptor`, and `WebConfig` so all views receive the current user and staff cannot bypass UI restrictions by typing protected URLs. Added `Account.isAdmin()` and fixed product validation/database mappings, including Unicode-safe `@Nationalized` fields.

## Phase 4 — portable data and documentation

Made H2 the default profile in `application.properties` and moved SQL Server settings to `application-sqlserver.properties`. Added 14 valid seeded products in four categories, including low-stock examples. Wrote this build log, a five-minute demo script, and the root README with profile and account instructions.
