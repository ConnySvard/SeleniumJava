# Playwright Test Suite

Automated end‑to‑end testing framework built with Playwright.  
Supports multiple customers, shared utilities, production safeguards, and automatic PDF reporting.

---

# 📁 Project Structure

```
root/
│
├── .env
├── playwright.config.ts
├── utils/
│   ├── global-setup.ts
│   ├── prod-guard.ts
│   └── reporter.ts
│
├── CustomerName1/
├── CustomerName2/
├── Cross-site tests/
│
└── README.md
```

---

# 👥 Customer Structure

Each customer has its own isolated folder:

```
root/
└── CustomerName1/
    ├── auth.ts
    ├── config.ts
    ├── .env
    ├── testdata/ (optional)
    ├── utils-customer/ (optional)
    └── tests/
        ├── example.spec.ts
```

### Customer Folder May Contain:

- `auth.ts` → Customer-specific authentication logic
- `config.ts` → Environment & base URL configuration
- `.env` → Optional customer-specific environment variables
- `testdata/` → Optional test data
- `utils-customer/` → Optional customer-specific utilities
- `tests/` → All test files for that customer

This keeps customer logic isolated while reusing shared utilities.

---

# 🔐 Environment Configuration

The root `.env` file contains global environment variables.

Example:

```properties
# .env
TESTER_NAME=Your name
```

### TESTER_NAME
Used in generated reports (including the automatically generated PDF report).

---

# 🧩 Shared Utilities (`/utils`)

The `utils` folder contains shared logic used across all customers.

---

## ✅ `global-setup.ts`

Handles:

- Authentication
- Cookie consent handling
- Navigation to base URL

This ensures consistent setup across all test suites.

---

## 🛡 `prod-guard.ts`

Prevents tests from running against production by default.

### Default Behavior (Blocked on Production)

```ts
prodGuard(config.isProd);
```

If `config.isProd === true`, the test will automatically be skipped.

---

### ✅ Explicitly Allow Test on Production

```ts
prodGuard(config.isProd, { allowOnProd: true });
```

This must be an explicit per‑test decision.

---

### 🔒 Production Safety Philosophy

- Production execution is **blocked by default**
- Running tests on production must always be intentional
- Each test must explicitly opt‑in

This prevents accidental execution against live environments.

---

## 📄 `reporter.ts`

Custom Playwright reporter that:

- Collects test results
- Automatically generates a PDF report after execution
- Includes the `TESTER_NAME` from `.env`

Configured in `playwright.config.ts`.

---



# 🖼 Screenshot Tool

Located under:

```
Cross-site tests/Screenshot-tool/
```

Supports:

- Configurable worker count
- Lazy loading handling
- Image load validation
- Scroll triggering for lazy images
- Configurable timeouts
- Parallel execution

Behavior is controlled via:

```
screenshots.config.json
```

---

# ⚙️ Playwright Configuration

```ts
// playwright.config.ts
import { defineConfig } from "@playwright/test";
import * as dotenv from "dotenv";
import * as path from "path";

dotenv.config({ path: path.resolve(__dirname, ".env") });

export default defineConfig({
  testDir: ".",
  testMatch: [
    "CustomerName1/tests/**/*.spec.ts",
    "CustomerName2/tests/**/*.spec.ts",
    "Cross-site tests/tests/**/*.spec.ts",
    "Cross-site tests/Screenshot-tool/*.spec.ts",
  ],
  timeout: 1200000,
  workers: 6,
  fullyParallel: true,
  reporter: [
    ["list"],
    ["./utils/reporter.ts"],
  ],
  use: {
    headless: false,
    viewport: { width: 1920, height: 1080 },
    actionTimeout: 120000,
  },
});
```

---

# 🚀 Running Tests

Run all tests:

```bash
npx playwright test
```

Run a specific test file:

```bash
npx playwright test path/to/file.spec.ts
```

Run the screenshot tool only:

```bash
npx playwright test Cross-site\ tests/Screenshot-tool/
```

---

# 📊 Reporting

After execution:

- Console output is displayed
- A PDF report is automatically generated
- The report includes:
  - Test results
  - Execution summary
  - `TESTER_NAME` from `.env`

---

# ✅ Best Practices

- Never commit credentials
- Always verify environment before execution
- Keep production runs explicit
- Avoid setting worker count too high
- Use shared utilities whenever possible

---
